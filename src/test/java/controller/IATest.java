package controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import modele.Gauffre;

@ExtendWith(MockitoExtension.class)
public class IATest {

	@Mock
	Gauffre gauffre;
	@Mock
	IA iaMock;

	@Test
	public void testNouvelle() {
		assertNotNull(IA.nouvelle(gauffre, "controller.IAA"));
	}

	@Test
	public void testNouvelleWithInvalidClass() {
		assertNull(IA.nouvelle(gauffre, "controller.IAA1"));
	}

	@Test
	public void testActiveA() {
		Mockito.doCallRealMethod().when(iaMock).ActiveIA();
		iaMock.ActiveIA();
		verify(iaMock).initialise();
	}

	@Test
	public void testDesactiverA() {
		Mockito.doCallRealMethod().when(iaMock).DesactiverIA();
		iaMock.DesactiverIA();
		verify(iaMock).DesactiverIA();
	}

	@ParameterizedTest
	@ValueSource(booleans = { true })
	public void testEstActiveWithActiveACall(boolean value) {
		Mockito.doCallRealMethod().when(iaMock).ActiveIA();
		iaMock.ActiveIA();
		Mockito.doCallRealMethod().when(iaMock).estActive();
		assertTrue(iaMock.estActive());
		verify(iaMock).estActive();
	}

	@ParameterizedTest
	@ValueSource(booleans = { false })
	public void testEstActiveWithoutActiveACall(boolean value) {
		Mockito.doCallRealMethod().when(iaMock).estActive();
		assertFalse(iaMock.estActive());
		verify(iaMock).estActive();
	}

	@Test
	public void testInitialise() {
		Mockito.doCallRealMethod().when(iaMock).initialise();
		iaMock.initialise();
		verify(iaMock).initialise();
	}
	@Test
	public void testJoue() {
		Mockito.doCallRealMethod().when(iaMock).joue();
		assertNull(iaMock.joue());
		verify(iaMock).joue();
	}
}