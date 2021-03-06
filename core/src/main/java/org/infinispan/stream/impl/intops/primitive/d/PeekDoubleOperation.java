package org.infinispan.stream.impl.intops.primitive.d;

import java.util.function.DoubleConsumer;
import java.util.stream.DoubleStream;

import org.infinispan.stream.impl.intops.IntermediateOperation;

import io.reactivex.Flowable;

/**
 * Performs peek operation on a {@link DoubleStream}
 */
public class PeekDoubleOperation implements IntermediateOperation<Double, DoubleStream, Double, DoubleStream> {
   private final DoubleConsumer consumer;

   public PeekDoubleOperation(DoubleConsumer consumer) {
      this.consumer = consumer;
   }

   @Override
   public DoubleStream perform(DoubleStream stream) {
      return stream.peek(consumer);
   }

   public DoubleConsumer getConsumer() {
      return consumer;
   }

   @Override
   public Flowable<Double> mapFlowable(Flowable<Double> input) {
      return input.doOnNext(consumer::accept);
   }
}
