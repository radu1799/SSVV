package ssvv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import domain.Tema;
import org.junit.Test;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.ValidationException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    private StudentXMLRepository repositoryStudent;
    private NotaXMLRepository repositoryNote;
    private TemaXMLRepository repositoryTema;
    private Service service;
    private StudentValidator validatorStudent;
    private NotaValidator validatorNota;
    private TemaValidator validatorTema;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void wbt_1()
    {
        String filenameStudent = "studenti.xml";
        String filenameTema = "teme.xml";
        String filenameNota = "note.xml";

        validatorStudent = new StudentValidator();
        repositoryStudent = new StudentXMLRepository(validatorStudent,filenameStudent);
        validatorNota = new NotaValidator();
        repositoryNote = new NotaXMLRepository(validatorNota,filenameNota);
        validatorTema = new TemaValidator();
        repositoryTema  = new TemaXMLRepository(validatorTema,filenameTema);
        service = new Service(repositoryStudent,repositoryTema,repositoryNote);

        try {
            int tema = service.saveTema("", "d", 1, 1);
            assertEquals(1, tema);
        }
        catch (ValidationException e){
            assert false;
        }
    }

    @Test
    public void wbt_2()
    {
        String filenameStudent = "studenti.xml";
        String filenameTema = "teme.xml";
        String filenameNota = "note.xml";

        validatorStudent = new StudentValidator();
        repositoryStudent = new StudentXMLRepository(validatorStudent,filenameStudent);
        validatorNota = new NotaValidator();
        repositoryNote = new NotaXMLRepository(validatorNota,filenameNota);
        validatorTema = new TemaValidator();
        repositoryTema  = new TemaXMLRepository(validatorTema,filenameTema);
        service = new Service(repositoryStudent,repositoryTema,repositoryNote);

        try {
            int tema = service.saveTema("1", "", 1,1);
            assertEquals(1, tema);
        }
        catch (ValidationException e){
            assert false;
        }
    }



}
