package org.example.command;

import org.example.model.Persona;

public interface Command {
    Persona execute();
}
