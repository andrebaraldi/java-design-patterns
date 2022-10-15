import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import br.com.baraldi.financeiroobserver.job.LancamentosVencidosJob;
import br.com.baraldi.financeiroobserver.listeners.EmailListener;
import br.com.baraldi.financeiroobserver.listeners.Listener;
import br.com.baraldi.financeiroobserver.listeners.SMSListener;
import br.com.baraldi.financeiroobserver.notifier.Notificador;
import br.com.baraldi.financeiroobserver.notifier.NotificadorLancamentosVencidos;
import br.com.baraldi.financeiroobserver.repository.Lancamentos;

public class Principal {

	public static void main(String[] args) throws Exception {
		
		Notificador notificador = new NotificadorLancamentosVencidos();
		
		// Cria os listeners e os lançamentos
		Listener enviadorEmail = new EmailListener(notificador);
		Listener enviadorSms = new SMSListener(notificador);
		Lancamentos lancamentos = new Lancamentos();
		
		
		// Novo JOB...
		JobDataMap jobDataMap = new JobDataMap();
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		
		// Adiciona os objetos do JOB: Lançamentos e Listeners
		jobDataMap.put("lancamentos", lancamentos);
		jobDataMap.put("notificador", notificador);
		
		// Configira o JOB
		JobDetail job = newJob(LancamentosVencidosJob.class)
						.setJobData(jobDataMap)
						.withIdentity("lancamentosVencidosJob", "lancamentosVencidosGroup")
						.build();

		// Disparo do JOB (tempo de disparo)
		CronTrigger trigger = newTrigger()
				.withIdentity("trigger1", "group1")
				.withSchedule(cronSchedule("0 * * * * ?"))
		        .build();

		// Associa JOB x Trigger de Disparo
		scheduler.scheduleJob(job, trigger);

		// Sobe o Scheduler
		scheduler.start();

		Thread.sleep(220000);

		scheduler.shutdown(true);
	}

}