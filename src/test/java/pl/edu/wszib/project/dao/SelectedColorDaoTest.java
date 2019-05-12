package pl.edu.wszib.project.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.wszib.project.domain.SelectedColor;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectedColorDaoTest {

    public static final String COLOR1 = "red";
    public static final String COLOR2 = "blue";


    @Autowired
    SelectedColorDao selectedColorDao;


    @Before
    public void setUp() throws Exception {

        SelectedColor selectedColor1 = new SelectedColor(COLOR1, new Date());
        SelectedColor selectedColor2 = new SelectedColor(COLOR2, new Date());

        assertNull(selectedColor1.getId()); //tu sprawdzxa czy nie ma nic w bazie na wstępie
        assertNull(selectedColor2.getId());

        selectedColorDao.save(selectedColor1); //zapisuje obiekt do bazy przy teście
        selectedColorDao.save(selectedColor2); //zapisuje obiekt do bazy przy teście

        assertNotNull(selectedColor1.getId()); // tu sprawdza czy się zapisało
        assertNotNull(selectedColor2.getId()); // tu sprawdza czy się zapisało

        System.out.println("-----------------------------------------------------------------------");

    }
    @Test
    public void testFetchAllData() {// metoda wyciągająca (fetch) wszystkie zapisane rekordy

        Iterable<SelectedColor> selectedColors = selectedColorDao.findAll();//pobiera wszystkie elementy z bazy danych
        int counter = 0;
        for (SelectedColor selectedColor : selectedColors){
            counter++;
        }
        assertTrue(counter >= 2);

    }
    @Test
    public void testFindByColor (){

        List<SelectedColor> selectedColors = selectedColorDao.findByColor(COLOR1);
        assertEquals(COLOR1, selectedColors.get(0).getColor());

    }
}