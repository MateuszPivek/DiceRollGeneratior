package pl.sda.project.skillRollGenerator.view.domain;

import pl.sda.project.skillRollGenerator.domain.NewCharacter;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.List;

public class InputNewCharacterFromConsole {
    private final Scanner scanner;

    public InputNewCharacterFromConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    public Optional <NewCharacter> inputNewCharacter() {
        System.out.println("Wpisz imię gracza: ");
        String playerName = scanner.nextLine();
        System.out.println("Wpisz imię postaci: ");
        String characterName = scanner.nextLine();
        System.out.println("Wpisz nazwisko postaci: ");
        String characterLastname = scanner.nextLine();
        System.out.println("Wpisz wiek postaci: ");
        int characterAge = scanner.nextInt();
        System.out.println("Wpisz kolejno wartości atrybutów postaci: ");
        int attributeCount = 1;
        List<Integer> attributes = new ArrayList<Integer>();
        do {
            System.out.println(attributeCount++ + " : ");
            int attribute = scanner.nextInt();
            attributes.add(attribute);
            System.out.println(" ");
        } while (attributes.size() < 8);
        System.out.println("Wpisz kolejno wartości umiejętności postaci: ");
        int skillCount = 1;
        List<Integer> skills = new ArrayList<Integer>();
        do {
            System.out.println(skillCount++ + " : ");
            int skill = scanner.nextInt();
            skills.add(skill);
            System.out.println(" ");
        } while (skills.size() < 45);
        return Optional.of(
                NewCharacter.builder()
                .playerName(playerName)
                .characterName(characterName)
                .characterLastname(characterLastname)
                .characterAge(characterAge)
                .attributes(attributes.toArray(new Integer[0]))
                .skills(skills.toArray(new Integer[0]))
                .build());
    }

}
