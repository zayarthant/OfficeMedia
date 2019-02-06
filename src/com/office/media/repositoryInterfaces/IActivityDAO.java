package com.office.media.repositoryInterfaces;

import com.office.media.entity.Activity;

public interface IActivityDAO extends IDAO<Activity>, ISearchByDate<Activity>, ISearchByContent<Activity> {

}
