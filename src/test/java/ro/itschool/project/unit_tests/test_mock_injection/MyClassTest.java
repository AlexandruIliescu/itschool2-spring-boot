package ro.itschool.project.unit_tests.test_mock_injection;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MyClassTest {

    @Mock
    private DependencyOne dependencyOne;

    @Mock
    private DependencyTwo dependencyTwo;

    @InjectMocks
    private MyClass myClass;

    @Test
    void testUseDependencies() {
        //given
        when(dependencyOne.doSomething()).thenReturn("Mocked DependencyOne");
        when(dependencyTwo.doSomething()).thenReturn("Mocked DependencyTwo");

        //when
        String result = myClass.useDependencies();

        //then
        Assertions.assertEquals("Mocked DependencyOne Mocked DependencyTwo", result);
    }
}