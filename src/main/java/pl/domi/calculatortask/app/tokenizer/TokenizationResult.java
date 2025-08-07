package pl.domi.calculatortask.app.tokenizer;

import java.util.List;
import pl.domi.calculatortask.app.rpn.kinds.OperatorKind;

public record TokenizationResult(List<Integer> numbers, List<OperatorKind> operators) {
}
