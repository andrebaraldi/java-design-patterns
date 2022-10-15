package br.com.baraldi.financeiroobserver.job;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import br.com.baraldi.financeiroobserver.listeners.EmailListener;
import br.com.baraldi.financeiroobserver.listeners.SMSListener;
import br.com.baraldi.financeiroobserver.model.Lancamento;
import br.com.baraldi.financeiroobserver.notifier.Notificador;
import br.com.baraldi.financeiroobserver.repository.Lancamentos;

public class LancamentosVencidosJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		
		Lancamentos lancamentos = (Lancamentos) jobDataMap.get("lancamentos");		
		List<Lancamento> lancamentosVencidos = lancamentos.todosVencidos();
		
		Notificador notificador = (Notificador) jobDataMap.get("notificador");
		notificador.novosLancamentosVencidos(lancamentosVencidos);
		
	}

}