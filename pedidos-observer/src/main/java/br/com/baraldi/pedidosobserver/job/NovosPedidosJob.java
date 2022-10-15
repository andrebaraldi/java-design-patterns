package br.com.baraldi.pedidosobserver.job;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import br.com.baraldi.pedidosobserver.model.Pedido;
import br.com.baraldi.pedidosobserver.notifiers.Notifier;

public class NovosPedidosJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		
		List<Pedido> novosPedidos = (List<Pedido>) jobDataMap.get("novosPedidos");
		
		Notifier notifier = (Notifier) jobDataMap.get("notifier");
		
		notifier.addNewPedidosList(novosPedidos);
		
	}

}
