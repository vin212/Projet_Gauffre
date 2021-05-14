package modele;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import structure.Point;

@ExtendWith(MockitoExtension.class)
public class GauffreTest {

	@Mock
	Gauffre gauffreMock;

	@Test
	public void testClone() {
		assertNotNull(new Gauffre(1, 2).Clone());
	}

	@Test
	public void testAfficherGauffre_CMD() {
		doCallRealMethod().when(gauffreMock).AfficherGauffre_CMD();
		gauffreMock.AfficherGauffre_CMD();
		verify(gauffreMock, times(1)).AfficherGauffre_CMD();
	}

	@Test
	public void testEstManager() {
		Gauffre gauffre = new Gauffre(3, 4);
		assertFalse(gauffre.EstManger(new Point(1, 0)));
	}

	@Test
	public void testMangerUnCarre() {
		Gauffre gauffre = new Gauffre(3, 4);
		gauffre.MangerUnCarre(new Point(1, 0));
		assertEquals(11, gauffre.getNbRestant());
	}

	@Test
	public void testEstPourri() {
		Gauffre gauffre = new Gauffre(3, 4);
		assertFalse(gauffre.EstPourri(new Point(1, 0)));
	}

	@Test
	public void testRemettreUnCarre() {
		Gauffre gauffre = new Gauffre(3, 4);
		gauffre.RemettreUnCarre(new Point(1, 0));
		assertEquals(13, gauffre.getNbRestant());
	}

	@Test
	public void testValeurTourCarre() {
		Gauffre gauffre = new Gauffre(3, 4);
		gauffre.ValeurTourCarre(new Point(1, 0));
		assertEquals(12, gauffre.getNbRestant());
	}
}