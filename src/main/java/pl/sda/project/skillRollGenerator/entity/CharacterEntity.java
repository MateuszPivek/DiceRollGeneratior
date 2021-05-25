package pl.sda.project.skillRollGenerator.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Characters")
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //CharacterInfo
    String playerName;
    String characterName;
    String characterLastname;
    int characterAge;

    //Attributes
    int strength;
    int dexterity;
    int power;
    int condition;
    int appearance;
    int education;
    int bodySize;
    int intelligence;

    //Skills
    int accounting;
    int anthropology;
    int appraise;
    int archeology;
    int artCraft;
    int charm;
    int climb;
    int creditRating;
    int cthulhuMythos;
    int disguise;
    int dodge;
    int driveAuto;
    int electricRepair;
    int fastTalk;
    int fightingBrawl;
    int firearmsHandgun;
    int firearmsRifle;
    int firstAid;
    int history;
    int intimidate;
    int jump;
    int foreignLanguage;
    int nativeLanguage;
    int law;
    int libraryUse;
    int listen;
    int locksmith;
    int mechanicalRepairs;
    int medicine;
    int naturalWorldKnowledge;
    int navigate;
    int occult;
    int operationHeavyMachine;
    int persuade;
    int pilot;
    int psychology;
    int psychoanalysis;
    int ride;
    int science;
    int sleightOfHand;
    int spotHidden;
    int stealth;
    int survival;
    int swim;
    int throwing;
    int track;
}

