package View;

import java.util.Scanner;
import Control.CtrTask;
import Model.Task;

/**
 *
 * Created by Frame-Code
 */
public class View {
    private final Scanner scanner = new Scanner(System.in);
    private final CtrTask control = new CtrTask();
    private boolean condition;
    private String option;

    public View() {
        this.condition = true;
        this.option = null;
    }

    public void InicializeView() {
        do {
            System.out.println("+---------------------GESTIONAR TAREAS---------------------+");
            System.out.println("Escribe el numero de la opcion correspondiente");
            System.out.println("1. Crear una nueva tarea");
            System.out.println("2. Editar una tarea existente");
            System.out.println("3. Ver todas las tareas");
            System.out.println("4. Eliminar tarea(por ID)");
            System.out.println("5. salir");
            option = scanner.nextLine();
            try {
                Integer.valueOf(option);

                if (Integer.parseInt(option) == 5) {
                    System.out.println("Bye");
                    condition = false;
                } else if (Integer.parseInt(option) >= 1 || Integer.parseInt(option) <= 5) {
                    checkKeyPressed(Integer.parseInt(option));
                } else {
                    System.out.println("Error! Selecciona una de las opciones mostradas, entre 1-5");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error! solo se admiten numeros");
            }

        } while (condition);

    }

    private void viewCreateTask() {
        System.out.println("+-------------------Crear tarea-----------------------+");
        System.out.println("Escribe el titulo de la tarea: ");
        String title = scanner.nextLine();

        System.out.println("Escribe la descripcion de la tarea: ");
        String description = scanner.nextLine();

        System.out.println("Escribe la fecha limite de la tarea (dd/mm/yy): ");
        String deadline = scanner.nextLine();

        control.createTask(title, description, deadline);
        System.out.println("Tarea creada correctamente");
    }

    private void viewEditTask() {
        System.out.println("+-------------------Editar tarea-----------------------+");
        System.out.println("Escribe el id de la tarea para editarla: ");
        String id = scanner.nextLine();
        try {
            Integer.valueOf(id);
            control.getTask(Integer.parseInt(id)).showDetails();
            System.out.println("+--------------------------------------------------+");
            System.out.println("Escribe el numero del tipo de edicion correspondiente");
            System.out.println("1. Editar titulo");
            System.out.println("2. Editar descripcion");
            System.out.println("3. Marcar como completada");
            System.out.println("4. Posponer fecha");
            option = scanner.nextLine();
            try {
                Integer.valueOf(option);
                if (Integer.parseInt(option) >= 1 || Integer.parseInt(option) <= 4) {
                    switch (Integer.parseInt(option)) {
                        case 1:
                            System.out.println("Escribe el nuevo titulo");
                            control.getTask(Integer.parseInt(id)).setTitle(scanner.nextLine());
                            System.out.println("Titulo registrado correctamente");
                            break;
                        case 2:
                            System.out.println("Escribe la nueva descripcion");
                            control.getTask(Integer.parseInt(id)).setDescription(scanner.nextLine());
                            System.out.println("Descripcion registrada correctamente");
                            break;
                        case 3:
                            control.getTask(Integer.parseInt(id)).checkToCompleted();
                            System.out.println("Tarea completada!");
                            break;
                        case 4:
                            System.out.println("Escribe la nueva fecha(dd/mm/yy)");
                            control.getTask(Integer.parseInt(id)).posponeDate(scanner.nextLine());
                            System.out.println("Fecha pospuesta correctamente");
                            break;
                    }
                    control.editTask(control.getTask(Integer.parseInt(id)));
                } else {
                    System.out.println("Error! Selecciona una de las opciones mostradas, entre 1-4");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error! solo se admiten numeros");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error! solo se admiten numeros");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Tarea no encontrada");
        }
    }

    private void viewListTask() {
        if (!control.getListTask().isEmpty()) {
            for (Task task : control.getListTask()) {
                System.out.println("+-------------------------------TAREA----------------------------------+");
                task.showDetails();
                System.out.println("+-------------------------------FINAL TAREA-------------------------------+");
            }
        } else {
            System.out.println("No existen tareas creadas");
        }
    }

    private void viewDeleteTask() {
        System.out.println("+-------------------Eliminar tarea-----------------------+");
        System.out.println("Escribe el id de la tarea: ");
        String id = scanner.nextLine();
        try {
            Integer.valueOf(id);
            control.deleteTask(Integer.parseInt(id));
            System.out.println("Tarea eliminada correctamente");
        } catch (NumberFormatException e) {
            System.out.println("Error! solo se admiten numeros");
        }
    }

    private void checkKeyPressed(int option) {
        switch (option) {
            case 1:
                viewCreateTask();
                break;
            case 2:
                viewEditTask();
                break;
            case 3:
                viewListTask();
                break;
            case 4:
                viewDeleteTask();
                break;
        }
    }

}
