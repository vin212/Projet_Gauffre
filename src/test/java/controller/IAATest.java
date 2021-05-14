package controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import modele.Gauffre;
import structure.Point;

@ExtendWith(MockitoExtension.class)
public class IAATest {

	@InjectMocks
	IAA iaaMock;
	@Mock
	Gauffre gauffre;
	@Mock
	Point pointMock;
	Controller controllerMock;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testJoue() {
		when(gauffre.hauteur()).thenReturn(1);
		when(gauffre.longueur()).thenReturn(1);
		try (MockedConstruction<Controller> controller = mockConstruction(Controller.class, (mock, context) -> {
		})) {

			try (MockedConstruction<Point> point = mockConstruction(Point.class, (mock, context) -> {
			})) {
				assertNotNull(iaaMock.joue());
			}

		}
	}

	@Test
	public void testJoueWithMoreThanOnePoint() {
		when(gauffre.hauteur()).thenReturn(2);
		when(gauffre.longueur()).thenReturn(2);
		try (MockedConstruction<Controller> controller = mockConstruction(Controller.class, (mock, context) -> {
			controllerMock = mock;
		})) {
			try (MockedConstruction<Point> point = mockConstruction(Point.class, (mock, context) -> {
				when(gauffre.EstManger(mock)).thenReturn(false);
				if (Integer.parseInt(context.arguments().get(0).toString()) == 0
						&& Integer.parseInt(context.arguments().get(1).toString()) == 1) {
					when(gauffre.EstManger(mock)).thenReturn(true);
				}
				if (Integer.parseInt(context.arguments().get(0).toString()) == 1
						&& Integer.parseInt(context.arguments().get(1).toString()) == 0) {
					when(gauffre.EstManger(mock)).thenReturn(true);
				}
			})) {

				assertNotNull(iaaMock.joue());
			}

		}
	}

	@Test
	public void testJoueWithMoreThanOnePointAndWithZeroCoordinates() {
		when(gauffre.hauteur()).thenReturn(2);
		when(gauffre.longueur()).thenReturn(2);
		try (MockedConstruction<Controller> controller = mockConstruction(Controller.class, (mock, context) -> {
			controllerMock = mock;
		})) {

			try (MockedConstruction<Point> point = mockConstruction(Point.class, (mock, context) -> {
				when(gauffre.EstManger(mock)).thenReturn(false);
				if (Integer.parseInt(context.arguments().get(0).toString()) == 0
						&& Integer.parseInt(context.arguments().get(1).toString()) == 1) {
					when(gauffre.EstManger(mock)).thenReturn(true);
				}
				if (Integer.parseInt(context.arguments().get(0).toString()) == 1
						&& Integer.parseInt(context.arguments().get(1).toString()) == 0) {
					when(gauffre.EstManger(mock)).thenReturn(true);
				}
				if (Integer.parseInt(context.arguments().get(0).toString()) == 0
						&& Integer.parseInt(context.arguments().get(1).toString()) == 0) {
					when(gauffre.EstManger(mock)).thenReturn(true);
				}
			})) {

				assertNotNull(iaaMock.joue());
			}

		}
	}
}
