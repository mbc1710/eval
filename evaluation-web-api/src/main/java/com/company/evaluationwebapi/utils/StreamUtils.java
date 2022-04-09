package com.company.evaluationwebapi.utils;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamUtils {

    public static <T> Stream<T> asStream (final Collection<T> collection) {
        return Optional.ofNullable(collection)
                .map(Collection::stream)
                .orElse(Stream.empty());
    }

    public static <T> Collection<T> asCollection (final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}
