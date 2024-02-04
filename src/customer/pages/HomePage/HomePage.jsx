import React from 'react'
import MainCarosel from '../../components/HomeCarosel/MainCarosel'
import HomeSectionCarosel from '../../components/HomeSectionCarosel/HomeSectionCarosel'
import { dressPage1 } from '../../../data/ecommerce-products-data/dress/page1'
import { mens_kurta } from '../../../data/ecommerce-products-data/Men/men_kurta'
import { mensPantsPage1 } from '../../../data/ecommerce-products-data/pants/men_page1'
const HomePage = () => {
  return (
    <div>
      <MainCarosel />
      <div className='space-y-10 py-20 flex flex-col justify-center px-5 lg:px-10'>
        <HomeSectionCarosel data={dressPage1} sectionName={"Dress"}/>
        <HomeSectionCarosel data={mens_kurta} sectionName={"Men Kurta"}/>
        <HomeSectionCarosel data={mensPantsPage1} sectionName={"Men pants"}/>
      </div>
    </div>
  )
}

export default HomePage