package day05;

import java.util.List;
import java.util.stream.Collectors;

public class BinaryBoarding {
    private final List<BoardingPass> boardingPasses;

    public BinaryBoarding(String input) {
        boardingPasses = input.lines()
                .map(BoardingPass::new)
                .collect(Collectors.toList());
    }

    public int getHighestSeatId() {
        return boardingPasses.stream()
                .mapToInt(BoardingPass::getId)
                .max()
                .orElseThrow();
    }

    public int getIdOfMySeat() {
        List<Integer> sortedBoardingPassIds = boardingPasses.stream()
                .map(BoardingPass::getId)
                .sorted()
                .collect(Collectors.toList());

        return findIdOfRemainingSeat(sortedBoardingPassIds);
    }

    private int findIdOfRemainingSeat(List<Integer> sortedBoardingPassIds) {
        int i = sortedBoardingPassIds.get(0);

        for (Integer boardingPassId : sortedBoardingPassIds) {
            if (boardingPassId != i) {
                return i;
            }
            i++;
        }

        throw new SeatNotFoundException();
    }
}
