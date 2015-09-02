/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.datatorrent;

import com.datatorrent.api.Context.OperatorContext;
import com.datatorrent.api.DefaultInputPort;
import com.datatorrent.api.Operator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomNumberConsumer implements Operator
{
  public final transient DefaultInputPort<Double> input = new DefaultInputPort<Double>()
  {
    @Override
    public void process(Double tuple)
    {
    }
  };

  @Override
  public void beginWindow(long l)
  {
    LOG.info("Beginning window");
  }

  @Override
  public void endWindow()
  {
  }

  @Override
  public void setup(OperatorContext cntxt)
  {
  }

  @Override
  public void teardown()
  {
  }

  private static final Logger LOG = LoggerFactory.getLogger(RandomNumberConsumer.class);
}
