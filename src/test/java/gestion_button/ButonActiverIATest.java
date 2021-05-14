package gestion_button;

import java.awt.event.ActionEvent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import components.AireDeDessin;
import controller.Controller;
import controller.IA;
import gestion_bouton.ButonActiverIA;
import modele.Gauffre;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class ButonActiverIATest {

	@InjectMocks
	ButonActiverIA butonActiverIA;
	@Mock
	Gauffre gauf;
	@Mock
	Controller ctrl;
	@Mock
	AireDeDessin aire;
	@Mock
	IA ia;

	@Mock
	ActionEvent mockAction;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testActionPerformed() {
		butonActiverIA.actionPerformed(mockAction);
		verify(ia, times(1)).ActiveIA();
	}

}
