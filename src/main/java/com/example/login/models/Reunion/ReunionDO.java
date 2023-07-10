package com.example.login.models.Reunion;

import java.util.Date;
import java.util.List;

public record ReunionDO(String nombreReunion, Date fechaReunion, List<Integer> usuarios,String tareas)  {
}
