package cleancode.studycafe.tobe.io;

import cleancode.studycafe.tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.StudyCafePass;
import cleancode.studycafe.tobe.model.StudyCafePassType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudyCafeFileHandler {
    private final String PATH_LIST_FILE_PATH = "src/main/resources/cleancode/studycafe/pass-list.csv";
    private final String LOCKER_FILE_PATH = "src/main/resources/cleancode/studycafe/locker.csv";

    public List<StudyCafePass> readStudyCafePasses() {
        try {
            List<String> passListLines = Files.readAllLines(Paths.get(PATH_LIST_FILE_PATH));
            return getStudyCafePasses(passListLines);
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

    public List<StudyCafeLockerPass> readLockerPasses() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(LOCKER_FILE_PATH));
            return getStudyCafeLockerPasses(lines);
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

    private static List<StudyCafePass> getStudyCafePasses(List<String> lines) {
        List<StudyCafePass> studyCafePasses = new ArrayList<>();
        for (String line : lines) {
            String[] values = line.split(",");
            StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
            int duration = Integer.parseInt(values[1]);
            int price = Integer.parseInt(values[2]);
            double discountRate = Double.parseDouble(values[3]);

            StudyCafePass studyCafePass = StudyCafePass.of(studyCafePassType, duration, price, discountRate);
            studyCafePasses.add(studyCafePass);
        }
        return studyCafePasses;
    }

    private static List<StudyCafeLockerPass> getStudyCafeLockerPasses(List<String> lines) {
        List<StudyCafeLockerPass> lockerPasses = new ArrayList<>();
        for (String line : lines) {
            String[] values = line.split(",");
            StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
            int duration = Integer.parseInt(values[1]);
            int price = Integer.parseInt(values[2]);

            StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(studyCafePassType, duration, price);
            lockerPasses.add(lockerPass);
        }
        return lockerPasses;
    }

}
