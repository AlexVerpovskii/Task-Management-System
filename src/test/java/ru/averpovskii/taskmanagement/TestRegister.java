package ru.averpovskii.taskmanagement;

import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.averpovskii.taskmanagement.converter.UserMapper;
import ru.averpovskii.taskmanagement.model.UserDto;
import ru.averpovskii.taskmanagement.model.ValidationErrorException;
import ru.averpovskii.taskmanagement.repository.UserRepository;
import ru.averpovskii.taskmanagement.service.TaskValidator;
import ru.averpovskii.taskmanagement.service.UserService;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {UserService.class})
@RequiredArgsConstructor
public class TestRegister {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserMapper userMapper;

    @MockBean
    private TaskValidator taskValidator;

    @Test(expected = ValidationErrorException.class)
    public void testRegister() {
        final var testUser = new UserDto();
        testUser.setEmail("test");
        testUser.setPassword("password");
        userService.save(testUser);
        }
}
