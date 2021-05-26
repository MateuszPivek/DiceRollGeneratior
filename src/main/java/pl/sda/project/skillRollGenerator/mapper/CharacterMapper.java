package pl.sda.project.skillRollGenerator.mapper;

import pl.sda.project.skillRollGenerator.domain.Character;
import pl.sda.project.skillRollGenerator.domain.CharacterAttributes;
import pl.sda.project.skillRollGenerator.domain.CharacterView;
import pl.sda.project.skillRollGenerator.domain.NewCharacter;
import pl.sda.project.skillRollGenerator.entity.CharacterEntity;

import java.util.ArrayList;
import java.util.List;

public enum CharacterMapper {
    INSTANCE;


    public CharacterEntity toEntity (NewCharacter newCharacter){
        Integer[] attributes = newCharacter.getAttributes();
        Integer[] skills = newCharacter.getSkills();
        return CharacterEntity.builder()
                .playerName(newCharacter.getPlayerName())
                .characterName(newCharacter.getCharacterName())
                .characterLastname(newCharacter.getCharacterLastname())
                .characterAge(newCharacter.getCharacterAge())
                .characterStrength(attributes[0])
                .characterDexterity(attributes[1])
                .characterPower(attributes[2])
                .characterCondition(attributes[3])
                .characterAppearance(attributes[4])
                .characterEducation(attributes[5])
                .characterBodySize(attributes[6])
                .characterIntelligence(attributes[7])
                .accounting(skills[0] + 5)
                .anthropology(skills[1] + 1)
                .appraise(skills[2] + 5)
                .archeology(skills[3] + 1)
                .artCraft(skills[4] + 5)
                .charm(skills[5] + 15)
                .climb(skills[6] + 20)
                .creditRating(skills[7])
                .cthulhuMythos(skills[8])
                .disguise(skills[9] + 5)
                .dodge(skills[10])
                .driveAuto(skills[11] + 20)
                .electricRepair(skills[12] + 10)
                .fastTalk(skills[13] + 5)
                .fightingBrawl(skills[14] + 25)
                .firearmsHandgun(skills[15] + 20)
                .firearmsRifle(skills[16] + 25)
                .firstAid(skills[17] + 30)
                .history(skills[18] + 5)
                .intimidate(skills[19] + 15)
                .jump(skills[20] + 20)
                .foreignLanguage(skills[20] + 1)
                .nativeLanguage(skills[21])
                .law(skills[22] + 5)
                .libraryUse(skills[23] + 20)
                .listen(skills[24] + 20)
                .locksmith(skills[25] + 1)
                .mechanicalRepairs(skills[26] + 10)
                .medicine(skills[27] + 1)
                .naturalWorldKnowledge(skills[28] + 10)
                .navigate(skills[29] + 10)
                .occult(skills[30] + 5)
                .operationHeavyMachine(skills[31] + 1)
                .persuade(skills[32] + 10)
                .pilot(skills[33] + 1)
                .psychology(skills[34] + 10)
                .psychoanalysis(skills[35] + 1)
                .ride(skills[36] + 5)
                .science(skills[37] + 1)
                .sleightOfHand(skills[38] + 10)
                .spotHidden(skills[39] + 25)
                .stealth(skills[40] + 20)
                .survival(skills[41] + 10)
                .swim(skills[42] + 20)
                .throwing(skills[43] + 20)
                .track(skills[44] + 10)
                .build();
    }

    public Character toFront (CharacterEntity entity){
        return Character.builder()
                .id(entity.getId())
                .playerName(entity.getPlayerName())
                .characterName(entity.getCharacterName())
                .characterLastname(entity.getCharacterLastname())
                .characterAge(entity.getCharacterAge())
                .build();
    }

    public CharacterAttributes toAttributesRoll (CharacterEntity entity){
        List<Integer> attributes = new ArrayList<>();
        if(entity.getCharacterStrength() != 0){
            attributes.add(entity.getCharacterStrength());
        }
        if(entity.getCharacterDexterity() != 0){
            attributes.add(entity.getCharacterDexterity());
        }
        if(entity.getCharacterPower() != 0){
            attributes.add(entity.getCharacterPower());
        }
        if(entity.getCharacterCondition() != 0){
            attributes.add(entity.getCharacterCondition());
        }
        if(entity.getCharacterAppearance() != 0){
            attributes.add(entity.getCharacterAppearance());
        }
        if(entity.getCharacterEducation() != 0){
            attributes.add(entity.getCharacterEducation());
        }
        if(entity.getCharacterBodySize() != 0){
            attributes.add(entity.getCharacterBodySize());
        }
        if(entity.getCharacterIntelligence() != 0){
            attributes.add(entity.getCharacterIntelligence());
        }
        return CharacterAttributes.builder()
                .id(entity.getId())
                .characterName(entity.getCharacterName())
                .characterLastname(entity.getCharacterLastname())
                .attributes(attributes.toArray(new Integer[8]))
                .build();
    }
}
