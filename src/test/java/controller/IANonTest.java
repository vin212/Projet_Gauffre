package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.doCallRealMethod;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import modele.Gauffre;
import structure.Point;

@ExtendWith(MockitoExtension.class)
public class IANonTest {

	@InjectMocks
	IANon iaNon;

	@Mock
	Gauffre gauffre;
	@Mock
	IANon iaNonMock;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testJoueWithColonneAndligneSetToTrue() {
		when(gauffre.hauteur()).thenReturn(3);
		when(gauffre.longueur()).thenReturn(2);
		when(gauffre.EstManger(Mockito.any())).thenReturn(true);
		Point actualPoint = iaNon.joue();
		assertEquals(0, actualPoint.getx());
		assertEquals(0, actualPoint.gety());
	}

	@Test
	public void testJoueWithColonneSetToFalse() {
		when(gauffre.hauteur()).thenReturn(3);
		when(gauffre.longueur()).thenReturn(2);
		try (MockedConstruction<Point> point = mockConstruction(Point.class, (mock, context) -> {
			if (Integer.parseInt(context.arguments().get(0).toString()) == 1
					&& Integer.parseInt(context.arguments().get(1).toString()) == 0) {
				when(gauffre.EstManger(mock)).thenReturn(true);
			}
			if (Integer.parseInt(context.arguments().get(0).toString()) == 2
					&& Integer.parseInt(context.arguments().get(1).toString()) == 0) {
				when(gauffre.EstManger(mock)).thenReturn(false);
			}
			if (Integer.parseInt(context.arguments().get(0).toString()) == 0
					&& Integer.parseInt(context.arguments().get(1).toString()) == 1) {
				when(gauffre.EstManger(mock)).thenReturn(true);
			}
		})) {
			assertNotNull(iaNon.joue());
		}

	}

	@Test
	public void testInitialise() {
		doCallRealMethod().when(iaNonMock).initialise();
		iaNonMock.initialise();
		verify(iaNonMock, times(1)).initialise();
	}
}
