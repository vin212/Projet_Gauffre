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
public class IAaleatoireTest {

	@InjectMocks
	IAaleatoire iAaleatoire;
	@Mock
	IAaleatoire iAaleatoireMock;
	@Mock
	Gauffre gauffre;
	Point expectedPoint;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testJoueWithEstManagerFalse() {
		when(gauffre.hauteur()).thenReturn(1);
		when(gauffre.longueur()).thenReturn(1);
		try (MockedConstruction<Point> point = mockConstruction(Point.class, (mock, context) -> {
			when(gauffre.EstManger(mock)).thenReturn(false);
			when(gauffre.EstPourri(mock)).thenReturn(false);
		})) {
			assertNotNull(iAaleatoire.joue());
		}
	}

	@Test
	public void testJoueWithEstManagerTrue() {
		when(gauffre.hauteur()).thenReturn(1);
		when(gauffre.longueur()).thenReturn(1);

		try (MockedConstruction<Point> point = mockConstruction(Point.class, (mock, context) -> {

			if (Integer.parseInt(context.arguments().get(0).toString()) == 0
					&& Integer.parseInt(context.arguments().get(1).toString()) == 0) {
				expectedPoint = mock;
			}
		})) {
			Point actualPoint = iAaleatoire.joue();
			assertEquals(expectedPoint.getx(), actualPoint.getx());
			assertEquals(expectedPoint.gety(), actualPoint.gety());
		}
	}

	@Test
	public void testInitialise() {
		doCallRealMethod().when(iAaleatoireMock).initialise();
		iAaleatoireMock.initialise();
		verify(iAaleatoireMock, times(1)).initialise();
	}
}
