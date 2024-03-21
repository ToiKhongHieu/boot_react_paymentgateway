import { Button } from '@mui/material';
import React, { useEffect, useRef, useState } from 'react';
import AliceCarousel from 'react-alice-carousel';
import 'react-alice-carousel/lib/alice-carousel.css';
import HomeSectionCard from '../HomeSectionCard/HomeSectionCard';
import KeyboardArrowLeftIcon from '@mui/icons-material/KeyboardArrowLeft';
const HomeSectionCarosel = (props) => {
    const carousel = useRef(AliceCarousel)
    const [activeIndex, setActiveIndex] = useState(0)
    const responsive = {
        0: { items: 1 },
        720: { items: 3 },
        1024: { items: 5.5 },
    };
    const items = props.data.slice(10).map(item => <HomeSectionCard product={item} />)
    return (
        <div className='px-4 lg:px-8 border'>
            <h2 className = "text-2xl font-extrabold text-gray-800 py-5">{props.sectionName}</h2>
            <div className='relative p-5'>
                <AliceCarousel
                    key="carousel"
                    mouseTracking
                    items={items}
                    disableButtonsControls
                    disableDotsControls
                    responsive={responsive}
                    ref={carousel}
                />
                    <Button variant='contained' className='z-50' disabled = {activeIndex == items.length - 5? true : false}
                        sx={{
                            possition: 'absolute', top: '8rem', right: '0rem', transform: 'translateX(2640%) translateY(-900%) rotate(90deg)'
                            , bgcolor: 'white' 
                        }} onClick={(e) => {
                            setActiveIndex(activeIndex + 1)
                            carousel?.current?.slideNext(e)
                        }}>
                        <KeyboardArrowLeftIcon sx={{ transform: 'rotate(90deg)', color: 'black' }} />
                    </Button>
                <Button variant='contained' className='z-50' disabled = {activeIndex == 0? true : false}
                    sx={{
                        possition: 'absolute', transform: 'translateX(-230%) translateY(-550%) rotate(90deg)'
                        , bgcolor: 'white'
                    }} onClick={(e) => {
                        setActiveIndex(activeIndex - 1)
                        carousel?.current?.slidePrev(e)
                    }}>
                    <KeyboardArrowLeftIcon sx={{ transform: 'rotate(-90deg)', color: 'black' }} />
                </Button>
            </div>
        </div>
    )
}
export default HomeSectionCarosel
