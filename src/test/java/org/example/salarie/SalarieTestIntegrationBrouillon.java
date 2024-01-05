//package org.example.salarie;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
//
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.verify;
//
//class SalarieTestIntegrationBrouillon {
//
//    @Mock
//    private Salarie salarie;
//
//    @InjectMocks
//    private Identite identite;
//
//    @InjectMocks
//    private Adresse adresse;
//
//    @BeforeEach
//    public void setUp(){
//        MockitoAnnotations.openMocks(this);
//    }
//
//
//
//    /**
//     * Liste d'adresse pour fournir en argument le test pour la méthode déménager (@testDemenager)
//     *
//     * @return Liste d'adresse
//     */
//    static Stream<Arguments> listeAdresse() {
//        return Stream.of(
//                Arguments.of(new Adresse(123, "Kampfwagen", "Die Wiedervereinigung", 12345, "Berlin", "Germany")),
//                Arguments.of(new Adresse(456, "Pizza", "De la mama", 67890, "Roma", "Italia"))
//
//        );
//    }
//
//    /**
//     * Test de la méthode déménager, un salarié est créé avec son identité et adresse,
//     * On teste la méthode en fournissant une nouvelle adresse à la fois à partir d'une liste d'adresse
//     *
//     * @param adresseNouvelle nouvelle adresse à partir d'une liste (listAdresse)
//     */
//    @ParameterizedTest(name = "Test déménager {index}")
//    @MethodSource("listeAdresse")
//    @DisplayName("Test déménager")
//    public void testDemenager(Adresse adresseNouvelle){
//        // Arrange
//        adresse = new Adresse(1, "cda", "m2i", 59000, "Lille", "France");
//        identite = new Identite(1, "Jean", "Passe", adresse);
//        Salarie salarieMock = Mockito.mock(Salarie.class, Mockito.CALLS_REAL_METHODS);
//
//        // Act
//        salarieMock.setIdentite(identite);
//        salarieMock.demenager(adresseNouvelle);
//
//        // Assert
//        assertTrue(new ReflectionEquals(adresseNouvelle).matches(salarieMock.getIdentite().getAdresse()));
//        verify(salarieMock).demenager(adresseNouvelle);
//    }
//
//
//    @Test
//    void travailler() {
//    }
//
//    @Test
//    void testTravailler() {
//    }
//
//    @Test
//    void augmenter() {
//    }
//}