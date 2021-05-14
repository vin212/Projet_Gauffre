package gestion_button;

import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import components.AireDeDessin;
import controller.Controller;
import gestion_bouton.ButonReset;
import gestion_bouton.ButonRetablir;
import modele.Gauffre;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class ButonRetablirTest {

	@InjectMocks
	ButonRetablir butonRetablir;
	@Mock
	Gauffre gauf;
	@Mock
	Controller ctrl;
	@Mock
	AireDeDessin aire;
	

	@Mock
	ActionEvent mockAction;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testActionPerformed() {
		butonRetablir.actionPerformed(mockAction);
		verify(ctrl, times(1)).retablirTour();
		verify(aire, times(1)).repaint();
	}

}
