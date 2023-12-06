import { Button } from '@mui/material';
import React from 'react';
import AliceCarousel from 'react-alice-carousel';
import 'react-alice-carousel/lib/alice-carousel.css';
import HomeSectionCard from '../HomeSectionCard/HomeSectionCard';
import KeyboardArrowLeftIcon from '@mui/icons-material/KeyboardArrowLeft';

const HomeSectionCarosel = () => {
    const responsive = {
        0: { items: 1 },
        568: { items: 4 },
        1024: { items: 5 },
    };
    const items = [1, 1, 1, 1, 1, 1, 1, 1, 1].map(item => <HomeSectionCard />)
    return (
        <div className='relative px-4 lg:px-8'>
            <div className='relative p-5'>
                <AliceCarousel
                    animationType="fadeout"
                    items={items}
                    disableButtonsControls
                    autoPlay
                    autoPlayInterval={1000}
                    responsive={responsive}
                    infinite
                />
                <Button variant='contained' className='z-50' sx={{ possition: 'absolute', top: '8rem', right: '0rem', transform: 'translateX(2140%) translateY(-1000%) rotate(90deg)' }}
                    aria-lable='next'>
                    <KeyboardArrowLeftIcon sx={{ transform: 'rotate(90deg)' }} />
                </Button>
            </div>
        </div>
    )
}
export default HomeSectionCarosel