
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeTest {
    @Test
    void returnGrade() {
        Grade grade = new Grade();
        assertEquals('B',grade.determineGrade(85));

    }
}