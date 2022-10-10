package es.heytrade.config.exceptions;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.util.StringUtils;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(Class clazz, String searchParamsMap) {
		super(EntityNotFoundException.generateMessage(clazz.getSimpleName(), searchParamsMap));
	}

	private static String generateMessage(String entity, String searchParams) {
		return StringUtils.capitalize(entity) + " no encontrado para " + searchParams;
	}

	private static <K, V> Map<K, V> toMap(Class<K> keyType, Class<V> valueType, Object... entries) {
		if (entries.length % 2 == 1)
			throw new IllegalArgumentException("parámetros incorrectos");
		return IntStream.range(0, entries.length / 2).map(i -> i * 2)
				.collect(HashMap::new,
					(m, i) -> m.put(keyType.cast(entries[i]), valueType.cast(entries[i + 1])),
					Map::putAll);
	}
}
