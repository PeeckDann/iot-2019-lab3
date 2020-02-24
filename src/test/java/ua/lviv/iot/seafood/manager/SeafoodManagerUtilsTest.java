package ua.lviv.iot.seafood.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.seafood.model.SortType;

public class SeafoodManagerUtilsTest extends BaseSeafoodManagerTest {
	
	@Test
	public void testSortingByPriceInGryvniasAscending() {
		SeafoodManagerUtils.sortByPriceInGryvnias(fish, SortType.ASC);
		assertEquals(10, fish.get(0).getPriceInGryvnias());
		assertEquals(50, fish.get(1).getPriceInGryvnias());
		assertEquals(100, fish.get(2).getPriceInGryvnias());
		assertEquals(150, fish.get(3).getPriceInGryvnias());
		assertEquals(170, fish.get(4).getPriceInGryvnias());
	}

	@Test
	public void testSortingByProducerAscending() {
		SeafoodManagerUtils.sortByProducer(fish, SortType.ASC);
		"Fifth Firm".compareTo(fish.get(0).getProducer());
		"First Firm".compareTo(fish.get(1).getProducer());
		"Fourth Firm".compareTo(fish.get(2).getProducer());
		"Second Firm".compareTo(fish.get(3).getProducer());
		"Third Firm".compareTo(fish.get(4).getProducer());
	}
}