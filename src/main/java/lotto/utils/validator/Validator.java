package lotto.utils.validator;

import java.util.List;
import lotto.exception.ExceptionCode;
import lotto.view.constant.Regex;

public class Validator {

    /**
     * 0~9 중 하나로 이루어져 있지 않다면 예외 발생
     */
    public static void isOnlyNumber(final String target, final ExceptionCode e) {
        if (!Regex.NUMBER.matches(target)) {
            e.throwException();
        }
    }

    /**
     * 리스트에 중복된 요소가 있다면 예외 발생
     */
    public static void isDuplication(final List<?> target, final ExceptionCode e) {
        long count = target.stream()
                .distinct()
                .count();

        if (count != target.size()) {
            e.throwException();
        }
    }

    /**
     * 주어진 숫자가 최대값보다 크거나 최솟값보다 작다면 예외 발생
     */
    public static void isValidRange(
            final int target,
            final int maximumSize,
            final int minimumSize,
            final ExceptionCode e
    ) {
        if (maximumSize < target || target < minimumSize) {
            e.throwException();
        }
    }

    /**
     * 리스트 길이가 최대값보다 크다면 예외 발생
     */
    public static void isOverSize(final List<?> target, final int maximumSize, final ExceptionCode e) {
        isValidSize(
                target,
                maximumSize,
                0,
                e
        );
    }

    /**
     * 리스트 길이가 최대값보다 크거나 최솟값보다 작다면 예외 발생
     */
    public static void isValidSize(
            final List<?> target,
            final int maximumSize,
            final int minimumSize,
            final ExceptionCode e
    ) {
        isValidRange(
                target.size(),
                maximumSize,
                minimumSize,
                e
        );
    }

    /**
     * 특정 요소가 포함되어 있지 않다면 예외가 발생. List.contains()를 사용한다.
     */
    public static <E> void contains(final List<E> target, final E element, final ExceptionCode e) {
        if (!target.contains(element)) {
            e.throwException();
        }
    }

    /**
     * 특정 요소가 포함되어 있다면 예외가 발생. List.contains()를 사용한다.
     */
    public static <E> void notContains(final List<E> target, final E element, final ExceptionCode e) {
        if (target.contains(element)) {
            e.throwException();
        }
    }

    /**
     * 리스트가 오직 특정한 요소들로 이루어져 있는지 확인. 만약 특정한 요소 외의 것이 포함되어 있다면 예외 발생.
     * @param target 검증할 리스트
     * @param validElements 유효한 요소 요소
     */
    public static <E> void containsOnly(final List<E> target, final List<E> validElements, final ExceptionCode e) {
        long countOfValidElementsInTarget = target.stream()
                .filter(validElements::contains)
                .count();

        if (countOfValidElementsInTarget != target.size()) {
            e.throwException();
        }
    }

    /**
     * 검증 대상이 특정 요소를 특정 개수보다 많이 포함하고 있다면 예외 발생
     * @param target 검증 대상 리스트
     * @param element 개수를 확인할 특정 요소
     * @param maximumCount 최대 허용 개수
     */
    public static <E> void containsOver(
            final List<E> target,
            final E element,
            final long maximumCount,
            final ExceptionCode e
    ) {
        long countOfElementInTarget = target.stream()
                .filter(element::equals)
                .count();

        if (countOfElementInTarget < maximumCount) {
            e.throwException();
        }
    }

    /**
     * 문자열 길이가 최대값보다 크다면 예외 발생
     */
    public static void isOverSize(final String target, final int maximumSize, final ExceptionCode e) {
        isValidSize(
                target,
                maximumSize,
                0,
                e
        );
    }

    /**
     * 문자열 길이가 최대값보다 크거나 최솟값보다 작다면 예외 발생
     */
    public static void isValidSize(
            final String target,
            final int maximumSize,
            final int minimumSize,
            final ExceptionCode e
    ) {
        isValidRange(
                target.length(),
                maximumSize,
                minimumSize,
                e
        );
    }

    /**
     * 문자열에 중복된 문자가 있다면 예외 발생
     */
    public static void isDuplication(final String target, final ExceptionCode e) {
        isDuplication(
                converToList(target),
                e
        );
    }

    /**
     * 특정 문자가 포함되어 있지 않다면 예외가 발생. List.contains()를 사용한다.
     */
    public static void contains(final String target, final String element, final ExceptionCode e) {
        contains(
                converToList(target),
                element,
                e
        );
    }

    /**
     * 특정 문자가 포함되어 있지 않다면 예외가 발생. List.contains()를 사용한다.
     */
    public static void notContains(final String target, final String element, final ExceptionCode e) {
        notContains(
                converToList(target),
                element,
                e
        );
    }

    /**
     * 특정 문자열이 정해진 문자들로만 이루어져 있지 않다면 예외 발생
     * @param target 검증 대상 문자열
     * @param validElements 유효한 구성 문자 리스트
     */
    public static void containsOnly(final String target, final List<Character> validElements, final ExceptionCode e) {
        containsOnly(
                converToList(target),
                validElements.stream()
                        .map(String::valueOf)
                        .toList(),
                e
        );
    }

    /**
     * 문자열이 특정 요소를 특정 개수보다 많이 포함하고 있다면 예외 발생.
     * @param target 검증 대상 문자열
     * @param element 개수를 확인할 특정 요소
     * @param maximumCount 최대 허용 개수
     */
    public static void containsOver(final String target, final char element, final long maximumCount, final ExceptionCode e) {
        containsOver(
                converToList(target),
                String.valueOf(element),
                maximumCount,
                e
        );
    }

    private static List<String> converToList(final String target) {
        return target.chars()
                .mapToObj(String::valueOf)
                .toList();
    }

    public static void isNoRemainder(final long molecule, final long denominator, final ExceptionCode e) {
        if (denominator == 0 || molecule % denominator != 0) {
            e.throwException();
        }
    }

    public static void isNegative(final long number, final ExceptionCode e) {
        if (number < 0) {
            e.throwException();
        }
    }

    public static void isNegative(final int number, final ExceptionCode e) {
        if (number < 0) {
            e.throwException();
        }
    }
}

