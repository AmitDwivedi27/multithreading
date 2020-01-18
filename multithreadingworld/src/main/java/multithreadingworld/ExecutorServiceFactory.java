package multithreadingworld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

public class ExecutorServiceFactory {

	private final Map<String, ExecutorService> executorServicesMap = new HashMap<>();

	private ExecutorServiceFactory() {

	}

	private static class ExecutorServiceFactoryHelper {
		private static final ExecutorServiceFactory EXECUTOR_SERVICE_FACTORY_SOLE_INSTANCE = new ExecutorServiceFactory();
	}

	public ExecutorService getExecutorService(Integer nThreads, String executorServiceName) {
		if (Objects.isNull(nThreads) || Objects.isNull(executorServiceName) || nThreads <= 0) {
			throw new IllegalArgumentException(
					"Number of threads , executorServiceName cannot be null and nThreads should be greater than 0");
		}
		ExecutorService executorService = null;
		if (executorServicesMap.get(executorServiceName) != null) {
			return executorServicesMap.get(executorServiceName);
		}

		BasicThreadFactory basicFactory = new BasicThreadFactory.Builder().namingPattern(executorServiceName + "-%d")
				.build();
		executorService = Executors.newFixedThreadPool(nThreads, basicFactory);
		executorServicesMap.put(executorServiceName, executorService);
		return executorService;
	}

	public ExecutorServiceFactory getExecutorServiceFactoryInstance() {
		return ExecutorServiceFactoryHelper.EXECUTOR_SERVICE_FACTORY_SOLE_INSTANCE;
	}

	public static void main(String[] args) {
		ExecutorServiceFactory exsFact = new ExecutorServiceFactory();
		ExecutorService exs = exsFact.getExecutorService(3, "AIR");
		ExecutorService exs1 = exsFact.getExecutorService(3, "AIR");
		System.out.println(exs.hashCode() == exs1.hashCode());

		List<Runnable> runnableList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Runnable r = () -> System.out.println(Thread.currentThread().getName() + " is working ");
			runnableList.add(r);
		}

	}

}
