package components;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mockConstruction;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import components.AireDeDessin;
import components.EcouteurDeSouris;
import components.Fenetre;
import controller.IAA;
import gestion_bouton.ButonActiverIA;
import gestion_bouton.ButonReset;
import gestion_bouton.ButonRetablir;
import gestion_bouton.ButonRetour;
import modele.Gauffre;

@ExtendWith(MockitoExtension.class)
public class FenetreTest {

	@InjectMocks
	Fenetre fenetre;
	@Mock
	Gauffre gauffre;
	@Mock
	JFrame frame;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRun() {

		try (MockedConstruction<JFrame> frame = mockConstruction(JFrame.class, (mock, context) -> {

		})) {

			try (MockedConstruction<IAA> iaa = mockConstruction(IAA.class, (mock, context) -> {
			}))

			{
				try (MockedConstruction<JLabel> label = mockConstruction(JLabel.class, (mock, context) -> {

				})) {
					try (MockedConstruction<JButton> bouton = mockConstruction(JButton.class, (mock, context) -> {

					})) {
						try (MockedConstruction<AireDeDessin> aireDeDessin = mockConstruction(AireDeDessin.class,
								(mock, context) -> {

								})) {
							try (MockedConstruction<JPanel> panel = mockConstruction(JPanel.class, (mock, context) -> {

							})) {

								try (MockedConstruction<ButonReset> resetBouton = mockConstruction(ButonReset.class,
										(mock, context) -> {

										})) {
									try (MockedConstruction<Dimension> dimension = mockConstruction(Dimension.class,
											(mock, context) -> {

											})) {

										try (MockedConstruction<ButonRetour> retourButon = mockConstruction(
												ButonRetour.class, (mock, context) -> {

												})) {
											try (MockedConstruction<ButonRetablir> retablirButon = mockConstruction(
													ButonRetablir.class, (mock, context) -> {

													})) {
												try (MockedConstruction<ButonActiverIA> activerIaButon = mockConstruction(
														ButonActiverIA.class, (mock, context) -> {

														})) {
													try (MockedConstruction<EcouteurDeSouris> ecouteurDeSouris = mockConstruction(
															EcouteurDeSouris.class, (mock, context) -> {

															})) {
														fenetre.run();
														Mockito.verify(gauffre).AfficherGauffre_CMD();
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}

			}

		}

	}

}
