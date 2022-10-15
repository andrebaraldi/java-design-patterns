package br.com.baraldi.sendmailproxy.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.baraldi.sendmailproxy.model.Contato;
import br.baraldi.sendmailproxy.proxy.MailSenderMandrillProxy;

// ------------------------------------------------
// Testes
//------------------------------------------------
public class SendMailProxyTester {
	
	List<Contato> contatos;
	MailSenderMandrillProxy sender;
	
	
	@Before
	public void init() {
		
		contatos = new ArrayList<Contato>() {{
			
						add( new Contato("Andre", "andre@teste.com")     );
						add( new Contato("Mailton", "mailton@teste.com") );
						add( new Contato("Carlos", "carlos@teste.com")   );
						add( new Contato("Luiz", "luiz@teste.com")       );	
						add( new Contato("Maria Rita", "mariarita@email.com"));
						
		}};	
		
		sender = new MailSenderMandrillProxy(contatos);
	}
	
	
	@Test
	public void emailDeveConstarNaBlackList() throws Exception {
		
		assertEquals(true, sender.getMailBlackList("mariarita@email.com"));
		
	}
	
	@Test
	public void emailNaoDeveConstarNaBlackList() throws Exception {
		
		assertEquals(false, sender.getMailBlackList("billgates@apple.com"));
		
	}
	
	
	@Test
	public void deveEnviarEmailsEFinalizarSemErro() throws Exception{
		
		sender.send();
		
		assertEquals(sender.getSendStatus(), true);		
	}
	
	@Test
	public void deveEnviarSomenteEmailsPermitidos() throws Exception {
		
		sender.send();
		
		assertEquals(sender.getSendCount(), 4);	
	}
	
}
