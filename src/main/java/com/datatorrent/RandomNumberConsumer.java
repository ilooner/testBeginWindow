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

import java.util.logging.Level;

public class RandomNumberConsumer implements Operator
{
  private transient boolean block = true;

  public final transient DefaultInputPort<Double> input = new DefaultInputPort<Double>()
  {
    @Override
    public void process(Double tuple)
    {
      if(block) {
        try {
          this.wait();
        } catch (InterruptedException ex) {
          throw new RuntimeException(ex);
        }
      }
    }
  };

  @Override
  public void beginWindow(long l)
  {
    block = false;
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
