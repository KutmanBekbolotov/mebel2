import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkerTest {

    //testing object's contructor and getter
    @Test

    public void testConstructorAndGetters() {

        Long expectedId = 1L;
        String expectedUsername = "username";
        String expectedPassword = "password";
        WORKER_ROLE expectedRole = WORKER_ROLE.ADMIN;

        Worker worker = new Worker();
        worker.setId(expectedId);
        worker.setUsername(expectedUsername);
        worker.setPassword(expectedPassword);
        worker.setWorkerRole(expectedRole);

        assertEquals(expectedId, worker.getId());
        assertEquals(expectedUsername, worker.getUsername());
        assertEquals(expectedPassword, worker.getPassword());
        assertEquals(expectedRole, worker.getWorkerRole());
    }

    //testing that to string works correct
    @Test

    public void testToString() {

        Worker worker = new Worker();
        worker.setId(1L);
        worker.setUsername("username");
        worker.setPassword("password");
        worker.setWorkerRole(WORKER_ROLE.ADMIN);

        String expectedString = "Worker(id=1, username=username, password=password, workerRole=ADMIN)";

        assertEquals(expectedString, worker.toString());
    }
}
