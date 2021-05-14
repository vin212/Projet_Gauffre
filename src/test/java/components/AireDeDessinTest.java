package components;

import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import controller.Controller;
import modele.Gauffre;
import structure.Point;

@ExtendWith(MockitoExtension.class)
public class AireDeDessinTest {

	AireDeDessin aireDeDessin;
	@Mock
	Controller controller;
	@Mock
	Gauffre gauffre;
	@Mock
	FileInputStream fileInputStream;
	@Mock
	BufferedImage image;
	Dimension dimension;
	Controller mockController;
	Point mockPoint;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testMangerMorceau() {

		try (MockedConstruction<Controller> controller = mockConstruction(Controller.class, (mock, context) -> {
			mockController = mock;
		})) {
			try (MockedConstruction<FileInputStream> fileInputStream = mockConstruction(FileInputStream.class,
					(mock, context) -> {

					})) {

				try (MockedStatic<ImageIO> imageIO = mockStatic(ImageIO.class)) {
					imageIO.when(() -> ImageIO.read(Mockito.any(InputStream.class))).thenReturn(image);

					try (MockedConstruction<Point> point = mockConstruction(Point.class, (mock, context) -> {
						mockPoint = mock;
						when(mockController.Tour(mockPoint)).thenReturn(true);
					})) {

						when(gauffre.hauteur()).thenReturn(1);
						when(gauffre.longueur()).thenReturn(1);
						aireDeDessin = new AireDeDessin(gauffre);
						aireDeDessin.setSize(new Dimension(10, 40));
						aireDeDessin.MangerMorceau(20, 30);
						Mockito.verify(mockController).Tour(mockPoint);
					}
				}
			}
		}

	}

}
