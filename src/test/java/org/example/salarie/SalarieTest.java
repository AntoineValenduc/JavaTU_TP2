package org.example.salarie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SalarieTest {

    @Mock
    private Salarie salarie;

    @InjectMocks
    private Identite identite;

    @InjectMocks
    private Adresse adresse;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        salarie = Mockito.mock(Salarie.class, Mockito.CALLS_REAL_METHODS);
        salarie.setIdentite(identite);
        salarie.getIdentite().setAdresse(adresse);
    }

    @Test
    @DisplayName("Test méthode déménager")
    void demenager() {
        // Arrange
        adresse = new Adresse(1, "cda", "m2i", 59000, "Lille", "France");

        // Act
        salarie.setIdentite(identite);
        salarie.demenager(adresse);

        // Assert
        assertTrue(new ReflectionEquals(adresse).matches(salarie.getIdentite().getAdresse()));
        verify(salarie).demenager(adresse);
    }

    static Stream<Arguments> listeAdresseException() {
        return Stream.of(
                Arguments.of(new Adresse(123, null, "Die Wiedervereinigung", 12345, "Berlin", "Germany")),
                Arguments.of(new Adresse(0, "Pizza", "De la mama", 67890, "Roma", "Italia"))

        );
    }

    @ParameterizedTest(name = "Test Déménager Exception {index}")
    @MethodSource("listeAdresseException")
    @DisplayName("Test méthode déménager")
    void demenagerValeurVide(Adresse adresse) {

        // Assert
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> salarie.demenager(adresse));

        Assertions.assertEquals("Il ne doit pas y avoir de 0 ou de null dans l'adresse !", exception.getMessage());
    }

    @Test
    @DisplayName("Test travailler sans paramètre")
    void travailler() {

        verify(salarie).travailler();
        assertEquals("Le salarié " + identite.getPrenom() + " " + identite.getNom() + " a travaillé " + 151.65 + " heures et a perçu " + 1766.9554999999998 + " euros", salarie.travailler());

    }

    @Test
    @DisplayName("Test travailler avec paramètre")
    void testTravailler() {
    }

    @Test
    @DisplayName("Test Augmenter")
    void augmenter() {
    }
}