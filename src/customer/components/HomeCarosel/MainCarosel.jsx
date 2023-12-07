import React from 'react';
import AliceCarousel from 'react-alice-carousel';
import 'react-alice-carousel/lib/alice-carousel.css';
import MainCaroselData from './MainCaroselData';

const MainCarosel = () => {
    const items = MainCaroselData.map(item => <img className='cursor-pointer' role='presentation' src={item.image} alt=""/>)
    return (
        <AliceCarousel
            animationType="fadeout"
            mouseTracking
            items={items}
            controlsStrategy="alternate"
            disableButtonsControls
            autoPlay
            autoPlayInterval={1000}
            infinite
            autoWidth
        />
    )
}
export default MainCarosel