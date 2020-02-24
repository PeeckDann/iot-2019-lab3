package ua.lviv.iot.seafood.manager;

import java.util.Comparator;
import java.util.List;

import ua.lviv.iot.seafood.model.Seafood;
import ua.lviv.iot.seafood.model.SortType;

public class SeafoodManagerUtils {

	public static void sortByPriceInGryvnias(final List<Seafood> seafood, final SortType sortType) {
		Comparator<Seafood> comparator = Comparator.comparing(Seafood::getPriceInGryvnias);
		seafood.sort(sortType == SortType.ASC ? comparator : comparator.reversed());
	}

	public static void sortByProducer(final List<Seafood> seafood, final SortType sortType) {
		Comparator<Seafood> comparator = Comparator.comparing(Seafood::getProducer);
		seafood.sort(sortType == SortType.ASC ? comparator : comparator.reversed());
	}
}