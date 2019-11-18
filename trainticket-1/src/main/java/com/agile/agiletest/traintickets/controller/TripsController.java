package com.agile.agiletest.traintickets.controller;



import com.agile.agiletest.traintickets.Result.Result;
import com.agile.agiletest.traintickets.pojo.Trips;
import com.agile.agiletest.traintickets.service.TripsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 查询车票
 * */
@RestController
@CrossOrigin
public class TripsController {
  

    @Autowired
    private TripsService tripsService;
    /**
     * get aim trips
     */
    
    @PostMapping("/getAimtrips")
    @ResponseBody
    public Result getAimtrips(@RequestBody Trips trips){
        Result result = tripsService.getAimtrips(trips);
        return result;
    }
    /**
     * get all trips
     * */
   
    @PostMapping("/getalltrips")
    @ResponseBody
    public Result getAlltrips(@RequestBody Trips trips){
        Result result = tripsService.getAlltrips(trips);
        return result;
    }
}
