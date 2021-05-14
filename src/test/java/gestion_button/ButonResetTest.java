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
import modele.Gauffre;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class ButonResetTest {

	@InjectMocks
	ButonReset butonReset;
	@Mock
	Gauffre gauf;
	@Mock
	Controller ctrl;
	@Mock
	AireDeDessin aire;
	@Mock
	JLabel mort;
	@Mock
	JLabel label;

	@Mock
	ActionEvent mockAction;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testActionPerformed() {
		butonReset.actionPerformed(mockAction);
		verify(ctrl, times(1)).restart();
		verify(aire, times(1)).repaint();
		verify(mort, times(1)).repaint();
		verify(label, times(1)).repaint();
	}

}
