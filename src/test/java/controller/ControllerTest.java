package controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import modele.Gauffre;
import structure.Point;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {
	@InjectMocks
	Controller controller;
	@Mock
	Gauffre gauffre;
	List<Gauffre> backup;

	Point pointMock;
	@Mock
	Point inputPoint;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRestart() {
		when(gauffre.hauteur()).thenReturn(2);
		when(gauffre.longueur()).thenReturn(2);

		try (MockedConstruction<Point> point = mockConstruction(Point.class, (mock, context) -> {
			pointMock = mock;
		})) {
			doReturn(1).when(gauffre).getNbRestant();
			when(gauffre.getTour()).thenReturn(0);
			controller.restart();
			verify(gauffre, times(2)).AfficherGauffre_CMD();
			verify(gauffre, times(1)).RemettreUnCarre(pointMock);
			verify(gauffre, times(1)).getNbRestant();
		}
	}

	@Test
	public void testRestartWithZeroLongueur() {
		when(gauffre.hauteur()).thenReturn(2);
		when(gauffre.longueur()).thenReturn(0);
		doReturn(1).when(gauffre).getNbRestant();
		when(gauffre.getTour()).thenReturn(0);
		controller.restart();
		verify(gauffre, times(2)).AfficherGauffre_CMD();
		verify(gauffre, never()).RemettreUnCarre(pointMock);
		verify(gauffre, times(1)).getNbRestant();
	}

	@Test
	public void testRestartWithZeroHauteur() {
		when(gauffre.hauteur()).thenReturn(0);
		doReturn(1).when(gauffre).getNbRestant();
		when(gauffre.getTour()).thenReturn(0);
		controller.restart();
		verify(gauffre, times(2)).AfficherGauffre_CMD();
		verify(gauffre, never()).RemettreUnCarre(pointMock);
		verify(gauffre, times(1)).getNbRestant();
	}

	@Test
	public void testAnnuleTour() {
		when(gauffre.Clone()).thenReturn(gauffre);
		when(gauffre.hauteur()).thenReturn(2);
		when(gauffre.longueur()).thenReturn(1);
		when(gauffre.getTour()).thenReturn(2);
		try (MockedConstruction<Point> point = mockConstruction(Point.class, (mock, context) -> {
			pointMock = mock;
		})) {
			when(gauffre.ValeurTourCarre(Mockito.any())).thenReturn(1);
			controller.annulerTour();
			verify(gauffre, times(1)).RemettreUnCarre(pointMock);
			verify(gauffre, times(1)).DecrementeTour();
		}
	}

	@Test
	public void testAnnuleTourWithZeroHauteur() {
		when(gauffre.Clone()).thenReturn(gauffre);
		when(gauffre.hauteur()).thenReturn(0);
		controller.annulerTour();
		verify(gauffre, never()).RemettreUnCarre(pointMock);
		verify(gauffre, times(1)).DecrementeTour();
	}

	@Test
	public void testAnnuleTourWithZeroLongueur() {
		when(gauffre.Clone()).thenReturn(gauffre);
		when(gauffre.hauteur()).thenReturn(1);
		when(gauffre.longueur()).thenReturn(0);
		controller.annulerTour();
		verify(gauffre, never()).RemettreUnCarre(pointMock);
		verify(gauffre, times(1)).DecrementeTour();
	}

	@Test
	public void testRetablirTour() {
		backup = new ArrayList<Gauffre>();
		backup.add(gauffre);
		controller.backup = backup;
		controller.retablirTour();
		verify(gauffre, times(1)).IncrementeTour();
	}

	@ParameterizedTest
	@ValueSource(booleans = { false })
	public void testTourWithEstManagerTrue(boolean value) {
		when(gauffre.EstManger(inputPoint)).thenReturn(true);
		controller.Tour(inputPoint);
		assertFalse(value);
	}

	@ParameterizedTest
	@ValueSource(booleans = { true })
	public void testTourWithInputPointEstManagerFalse(boolean value) {
		when(inputPoint.getx()).thenReturn(1);
		when(inputPoint.gety()).thenReturn(1);
		when(gauffre.hauteur()).thenReturn(2);
		when(gauffre.longueur()).thenReturn(2);
		try (MockedConstruction<Point> point = mockConstruction(Point.class, (mock, context) -> {
			pointMock = mock;
			when(gauffre.EstPourri(inputPoint)).thenReturn(true);
		})) {
			controller.Tour(inputPoint);
			assertTrue(value);
			verify(gauffre, times(1)).MangerUnCarre(pointMock);
		}
	}

	@ParameterizedTest
	@ValueSource(booleans = { true })
	public void testTourWithNewPointEstManagerFalse(boolean value) {
		when(inputPoint.getx()).thenReturn(1);
		when(inputPoint.gety()).thenReturn(1);
		when(gauffre.hauteur()).thenReturn(2);
		when(gauffre.longueur()).thenReturn(2);
		try (MockedConstruction<Point> point = mockConstruction(Point.class, (mock, context) -> {
			pointMock = mock;
			when(gauffre.EstManger(pointMock)).thenReturn(true);
			when(gauffre.EstPourri(inputPoint)).thenReturn(true);
		})) {
			controller.Tour(inputPoint);
			assertTrue(value);
			verify(gauffre, never()).MangerUnCarre(pointMock);
		}
	}

}
