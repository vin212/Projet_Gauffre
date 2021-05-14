package gestion_button;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
import gestion_bouton.ButonRetour;
import modele.Gauffre;

@ExtendWith(MockitoExtension.class)
public class ButonRetourTest {

	@InjectMocks
	ButonRetour butonRetour;
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
		butonRetour.actionPerformed(mockAction);
		verify(ctrl, times(1)).annulerTour();
		verify(aire, times(1)).repaint();
	}

}
