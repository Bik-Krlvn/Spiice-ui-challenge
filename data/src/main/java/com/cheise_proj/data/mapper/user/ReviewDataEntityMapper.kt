package com.cheise_proj.data.mapper.user

import com.cheise_proj.data.mapper.IDataListMapper
import com.cheise_proj.data.mapper.IDataMapper
import com.cheise_proj.data.model.ReviewsData
import com.cheise_proj.data.model.UserData.Companion.userMapper
import com.cheise_proj.domain.entities.user.ReviewsEntity

class ReviewDataEntityMapper : IDataMapper<ReviewsData, ReviewsEntity>,
    IDataListMapper<ReviewsData, ReviewsEntity> {
    override fun dataToEntity(data: ReviewsData): ReviewsEntity {
        return ReviewsEntity(
            content = data.content,
            timestamp = data.timestamp,
            rating = data.rating,
            id = data.id,
            sender = userMapper().dataToEntity(data.sender)
        )
    }

    override fun entityToData(entity: ReviewsEntity): ReviewsData {
        return ReviewsData(
            content = entity.content,
            timestamp = entity.timestamp,
            rating = entity.rating,
            id = entity.id,
            sender = userMapper().entityToData(entity.sender)
        )
    }

    override fun dataListToEntity(dataList: List<ReviewsData>): List<ReviewsEntity> {
        val entity = arrayListOf<ReviewsEntity>()
        dataList.forEach { data -> entity.add(dataToEntity(data)) }
        return entity
    }

    override fun entityListToData(entityList: List<ReviewsEntity>): List<ReviewsData> {
        val data = arrayListOf<ReviewsData>()
        entityList.forEach { entity -> data.add(entityToData(entity)) }
        return data
    }
}