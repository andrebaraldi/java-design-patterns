import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.List;

import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import br.com.baraldi.pedidosobserver.job.NovosPedidosJob;
import br.com.baraldi.pedidosobserver.listeners.FaturamentoListener;
import br.com.baraldi.pedidosobserver.listeners.Listener;
import br.com.baraldi.pedidosobserver.listeners.TransporteListener;
import br.com.baraldi.pedidosobserver.model.Pedido;
import br.com.baraldi.pedidosobserver.notifiers.Notifier;
import br.com.baraldi.pedidosobserver.notifiers.PedidosNotifier;
import br.com.baraldi.pedidosobserver.sources.PedidosXML;

public class Principal {

	
	public static void main(String[] args) throws Exception  {
		
		
		// XML itens...
		// -------------------
		PedidosXML pedidosXML = new PedidosXML();
		
		List<Pedido> novosPedidos = pedidosXML.getFromXML("pedidos.xml");
		
		
		// Observer Structure
		// -------------------------		
		Notifier notifier = new PedidosNotifier();
		Listener faturamentoListener = new FaturamentoListener(notifier);
		Listener transporteListener = new TransporteListener(notifier);
		
		
		// New JOB...
		// -------------------
		JobDataMap jobDataMap = new JobDataMap();
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		
		// Add Itens, Notifier (and its listeners) to the JOB Map 
		jobDataMap.put("novosPedidos", novosPedidos);
		jobDataMap.put("notifier", notifier);
		
		// Set Details to the JOB
		JobDetail job = newJob(NovosPedidosJob.class)
						.setJobData(jobDataMap)
						.withIdentity("novosPedidosJob", "NovosPedidosGroup")
						.build();
		

		// Disparo do JOB (tempo de disparo)
		CronTrigger trigger = newTrigger()
				.withIdentity("trigger1", "group1")
				.withSchedule(cronSchedule("0 * * * * ?"))
		        .build();

		
		// Associa JOB x Trigger de disparo
		scheduler.scheduleJob(job, trigger);

		// Sobe o Scheduler
		scheduler.start();

		Thread.sleep(220000);

		scheduler.shutdown(true);		
		
	}

}
