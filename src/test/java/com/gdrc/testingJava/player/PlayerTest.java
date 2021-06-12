package com.gdrc.testingJava.player;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void looses_when_dice_number_is_too_low() {
        /*
        * Como no podemos probar si el dado funciona porque
        * devolvera numeros aleatorios que no podemos predecir,
        * creamos un mock de la clase Dice para simular el
        * comportamiento
        * */
        //Dice dice = new Dice(6);
        Dice dice = Mockito.mock(Dice.class);
        //Aca simulamos la funcion y forzamos a que cuando se ejecute
        // la funcion, devuelva lo que queremos.
        Mockito.when(dice.roll()).thenReturn(2);
        Player player = new Player(dice, 3);
        assertFalse(player.play());
    }

    @Test
    public void wins_when_dice_number_is_bigger() {
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(4);
        Player player = new Player(dice, 3);
        assertTrue(player.play());
    }
}