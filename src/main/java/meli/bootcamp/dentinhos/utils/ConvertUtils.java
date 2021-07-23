package meli.bootcamp.dentinhos.utils;

import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertUtils {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static <D, T> D map(final T entity, Class<D> outClass) {
        return MAPPER.map(entity, outClass);
    }

    public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }
}
