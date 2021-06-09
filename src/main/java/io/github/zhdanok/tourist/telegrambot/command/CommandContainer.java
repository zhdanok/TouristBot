package io.github.zhdanok.tourist.telegrambot.command;

import com.google.common.collect.ImmutableMap;
import io.github.zhdanok.tourist.telegrambot.service.SendBotMessageServiceInterface;

import static io.github.zhdanok.tourist.telegrambot.command.CommandName.START;

public class CommandContainer {

    public final ImmutableMap<String, Command> commandMap;

    public CommandContainer(SendBotMessageServiceInterface sendBotMessageServiceI) {

        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartComm(sendBotMessageServiceI))
                .build();

        //unknownComm = new UnknownComm(sendBotMessageServiceI);
    }

    public Command retrieveCommand(String commandIdentifier) {
        //return commandHandler.commandMap.getOrDefault(commandIdentifier, unknownComm);
        return commandMap.get(commandIdentifier);
    }
}
