package components;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import controller.IA;
import modele.Gauffre;
import structure.Point;

@ExtendWith(MockitoExtension.class)
public class EcouteurDeSourisTest {

	@InjectMocks
	EcouteurDeSouris ecouteurDeSouris;
	@Mock
	AireDeDessin aire;
	@Mock
	Gauffre gauf;
	@Mock
	JLabel label;
	@Mock
	JLabel mort;
	@Mock
	IA ia;
	@Mock
	Point point;
	@Mock
	MouseEvent mockMouseEvent;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		aire.gauf = gauf;
		doNothing().when(label).repaint();
		doNothing().when(aire).repaint();
		doNothing().when(mort).repaint();
		when(mockMouseEvent.getX()).thenReturn(10);
		when(mockMouseEvent.getY()).thenReturn(50);
	}

	@Test
	public void testMousePressedEvent1() {
		when(gauf.getTour()).thenReturn(10);
		when(aire.MangerMorceau(mockMouseEvent.getX(), mockMouseEvent.getY())).thenReturn(true);
		ecouteurDeSouris.mousePressed(mockMouseEvent);
		verify(label, times(2)).repaint();
		verify(aire, times(1)).repaint();
		verify(mort, times(1)).repaint();
		verify(aire, times(1)).MangerMorceau(mockMouseEvent.getX(), mockMouseEvent.getY());
		verify(aire, never()).MangerMorceauIA(point);
	}

	@Test
	public void testMousePressedEvent2() {
		when(gauf.getTour()).thenReturn(15);
		when(aire.MangerMorceau(mockMouseEvent.getX(), mockMouseEvent.getY())).thenReturn(false);
		when(ia.estActive()).thenReturn(true);
		when(ia.joue()).thenReturn(point);
		when(aire.MangerMorceauIA(point)).thenReturn(true);
		ecouteurDeSouris.mousePressed(mockMouseEvent);
		verify(aire, times(1)).MangerMorceauIA(point);
		verify(label, times(2)).repaint();
		verify(aire, times(1)).repaint();
		verify(mort, times(1)).repaint();

	}
}
